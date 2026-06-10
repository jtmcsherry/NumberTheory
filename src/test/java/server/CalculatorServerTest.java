package server;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServerTest {
    private static HttpServer server;
    private static int port;
    private static HttpClient client;

    @BeforeAll
    static void startServer() throws Exception {
        server = CalculatorServer.start(0);
        port = server.getAddress().getPort();
        client = HttpClient.newHttpClient();
    }

    @AfterAll
    static void stopServer() {
        server.stop(0);
    }

    private HttpResponse<String> get(String path) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + path))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private void assertResult(String path, String expected) throws Exception {
        HttpResponse<String> resp = get(path);
        assertEquals(200, resp.statusCode());
        assertTrue(resp.body().contains("\"result\":" + expected),
                "Expected result=" + expected + " in " + resp.body());
    }

    @Test
    void testPhi() throws Exception {
        assertResult("/api/compute?function=phi&n=12", "4");
        assertResult("/api/compute?function=phi&n=1", "1");
        assertResult("/api/compute?function=phi&n=7", "6");
        assertResult("/api/compute?function=phi&n=100", "40");
    }

    @Test
    void testSigma() throws Exception {
        assertResult("/api/compute?function=sigma&n=12", "28");
        assertResult("/api/compute?function=sigma&n=6", "12");
        assertResult("/api/compute?function=sigma&n=1", "1");
    }

    @Test
    void testTau() throws Exception {
        assertResult("/api/compute?function=tau&n=12", "6");
        assertResult("/api/compute?function=tau&n=6", "4");
        assertResult("/api/compute?function=tau&n=1", "1");
    }

    @Test
    void testMu() throws Exception {
        assertResult("/api/compute?function=mu&n=12", "0");
        assertResult("/api/compute?function=mu&n=6", "1");
        assertResult("/api/compute?function=mu&n=30", "-1");
        assertResult("/api/compute?function=mu&n=1", "1");
    }

    @Test
    void testRad() throws Exception {
        assertResult("/api/compute?function=rad&n=12", "6");
        assertResult("/api/compute?function=rad&n=2000", "10");
        assertResult("/api/compute?function=rad&n=1", "1");
    }

    @Test
    void testLiouville() throws Exception {
        assertResult("/api/compute?function=liouville&n=12", "-1");
        assertResult("/api/compute?function=liouville&n=6", "1");
        assertResult("/api/compute?function=liouville&n=1", "1");
    }

    @Test
    void testPsi() throws Exception {
        assertResult("/api/compute?function=psi&n=12", "24");
        assertResult("/api/compute?function=psi&n=6", "12");
        assertResult("/api/compute?function=psi&n=1", "1");
    }

    @Test
    void testSquareFree() throws Exception {
        assertResult("/api/compute?function=squareFree&n=12", "0");
        assertResult("/api/compute?function=squareFree&n=6", "1");
        assertResult("/api/compute?function=squareFree&n=1", "1");
    }

    @Test
    void testIsPerfect() throws Exception {
        assertResult("/api/compute?function=isPerfect&n=6", "0");
        assertResult("/api/compute?function=isPerfect&n=12", "1");
        assertResult("/api/compute?function=isPerfect&n=5", "-1");
    }

    @Test
    void testOne() throws Exception {
        assertResult("/api/compute?function=one&n=12", "1");
        assertResult("/api/compute?function=one&n=100", "1");
    }

    @Test
    void testIdentity() throws Exception {
        assertResult("/api/compute?function=identity&n=12", "12");
        assertResult("/api/compute?function=identity&n=1", "1");
    }

    @Test
    void testUnitFunction() throws Exception {
        assertResult("/api/compute?function=unitFunction&n=12", "0");
        assertResult("/api/compute?function=unitFunction&n=1", "1");
    }

    @Test
    void testUpperOmega() throws Exception {
        assertResult("/api/compute?function=upperOmega&n=12", "3");
        assertResult("/api/compute?function=upperOmega&n=2000", "7");
        assertResult("/api/compute?function=upperOmega&n=1", "0");
    }

    @Test
    void testLowerOmega() throws Exception {
        assertResult("/api/compute?function=lowerOmega&n=12", "2");
        assertResult("/api/compute?function=lowerOmega&n=2000", "2");
        assertResult("/api/compute?function=lowerOmega&n=1", "0");
    }

    @Test
    void testSumPrimes() throws Exception {
        assertResult("/api/compute?function=sumPrimes&n=2000", "23");
        assertResult("/api/compute?function=sumPrimes&n=12", "7");
    }

    @Test
    void testSumDistinctPrimeDivisors() throws Exception {
        assertResult("/api/compute?function=sumDistinctPrimeDivisors&n=2000", "7");
        assertResult("/api/compute?function=sumDistinctPrimeDivisors&n=12", "5");
    }

    @Test
    void testIsPrime() throws Exception {
        HttpResponse<String> resp = get("/api/compute?function=isPrime&n=7");
        assertEquals(200, resp.statusCode());
        assertTrue(resp.body().contains("\"result\":true"));
        assertTrue(resp.body().contains("\"factorization\":\"7¹\""));
    }

    @Test
    void testLegendreSymbol() throws Exception {
        assertResult("/api/compute?function=legendreSymbol&n=5&p=23", "-1");
        assertResult("/api/compute?function=legendreSymbol&n=4&p=7", "1");
        assertResult("/api/compute?function=legendreSymbol&n=7&p=7", "0");
    }

    @Test
    void testFactorizationFormat() throws Exception {
        HttpResponse<String> resp = get("/api/compute?function=phi&n=12");
        assertTrue(resp.body().contains("2²"), "Expected superscript 2 in " + resp.body());
        assertTrue(resp.body().contains("3¹"), "Expected superscript 1 in " + resp.body());
    }

    @Test
    void testErrorUnknownFunction() throws Exception {
        HttpResponse<String> resp = get("/api/compute?function=nonexistent&n=1");
        assertEquals(200, resp.statusCode());
        assertTrue(resp.body().contains("\"error\""));
    }

    @Test
    void testErrorMissingN() throws Exception {
        HttpResponse<String> resp = get("/api/compute?function=phi");
        assertEquals(200, resp.statusCode());
        assertTrue(resp.body().contains("\"error\""));
    }
}
