package api.users;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UserClient extends all.RestAssuredClient {

    private final String USER_REGISTRATION = "api/auth/register";
    private final String USER_AUTH = "api/auth/user";
    private final String USER_LOGIN = "api/auth/login";

    @Step("Отправить запрос POST с json в теле для регистрации аккаунта пользователя на /api/auth/register")
    public Response sentPostToCreateUser(User userData) {
        return reqSpec.and().body(userData).when().post(USER_REGISTRATION);
    }

    @Step("Отправить запрос POST с json в теле для авторизации пользователя  на /api/auth/user")
    public Response sentPostToLogin(UserCredentials userCredentials) {
        return reqSpec.and().body(userCredentials).when().post(USER_LOGIN);
    }

    @Step("Отправить запрос DELETE с авторизацией по токену для удаления аккаунта пользователя на /api/auth/user")
    public Response sentDeleteToRemoveUser(String accessToken) {
        return reqSpecWithoutBody.auth().oauth2(accessToken).when().delete(USER_AUTH);
    }

    @Step("Проверить, что код ответа 200 и значение атрибута success - true в теле ответа.")
    public String compareResponseCode200AndBodySuccessTrueAndReturnToken(Response response) {
        response.then().assertThat().statusCode(SC_OK).and().body("success", is(true));
        return response.then().extract().path("accessToken").toString().substring(7);
    }

    @Step("Проверить, что код ответа 200, значение атрибута success - true, и значение атрибута message совпадает с \"User successfully removed\".")
    public void compareResponseCodeAndBodyAboutRemove(Response response) {
        response.then().assertThat().statusCode(SC_ACCEPTED).and().body("success", is(true)).and().body("message", is("User successfully removed"));
    }

}
