package engine;

import io.restassured.response.Response;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/7/2021
 * #Comments:
 */
public interface IRestResponse<T> {
    public T getBody();

    public String getContent();

    public int getStatusCode();

    public boolean isSuccessful();

    public String getStatusDescription();

    public Response getResponse();

    public Exception getException();
}
