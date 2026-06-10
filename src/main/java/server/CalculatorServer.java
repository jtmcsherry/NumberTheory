package server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import functions.*;
import java.net.InetSocketAddress;
import java.io.*;
import java.util.*;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new StaticHandler());
        server.createContext("/api/compute", new ComputeHandler());
        server.setExecutor(null);
        System.out.println("Number Theory Calculator running at http://localhost:8080");
        server.start();
    }
}

class StaticHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        if (path.equals("/")) path = "/index.html";

        InputStream is = getClass().getResourceAsStream("/static" + path);
        if (is == null) {
            String response = "404 Not Found";
            exchange.sendResponseHeaders(404, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
            return;
        }

        String contentType = "text/html";
        if (path.endsWith(".css")) contentType = "text/css";
        else if (path.endsWith(".js")) contentType = "application/javascript";

        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(200, 0);
        is.transferTo(exchange.getResponseBody());
        exchange.getResponseBody().close();
        is.close();
    }
}

class ComputeHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Content-Type", "application/json");

        try {
            Map<String, String> params = parseQuery(exchange.getRequestURI().getQuery());
            String function = params.get("function");
            int n = Integer.parseInt(params.get("n"));

            PrimeFactorization pf = new PrimeFactorization(n);
            Object result;

            switch (function) {
                case "upperOmega":
                    result = AddativeFunctions.upperOmega(pf);
                    break;
                case "lowerOmega":
                    result = AddativeFunctions.lowerOmega(pf);
                    break;
                case "sumPrimes":
                    result = AddativeFunctions.sumPrimes(pf);
                    break;
                case "sumDistinctPrimeDivisors":
                    result = AddativeFunctions.sumDistinctPrimeDivisors(pf);
                    break;
                case "phi":
                    result = MultiplicativeFunctions.phi(pf);
                    break;
                case "sigma":
                    result = MultiplicativeFunctions.sigma(pf);
                    break;
                case "tau":
                    result = MultiplicativeFunctions.tau(pf);
                    break;
                case "mu":
                    result = MultiplicativeFunctions.mu(pf);
                    break;
                case "one":
                    result = MultiplicativeFunctions.one(pf);
                    break;
                case "identity":
                    result = MultiplicativeFunctions.identity(pf);
                    break;
                case "unitFunction":
                    result = MultiplicativeFunctions.unitFunction(pf);
                    break;
                case "rad":
                    result = MultiplicativeFunctions.rad(pf);
                    break;
                case "liouville":
                    result = MultiplicativeFunctions.liouville(pf);
                    break;
                case "psi":
                    result = MultiplicativeFunctions.psi(pf);
                    break;
                case "squareFree":
                    result = MultiplicativeFunctions.squareFree(pf);
                    break;
                case "isPerfect":
                    result = MultiplicativeFunctions.isPerfect(pf);
                    break;
                case "isPrime":
                    result = PrimeFactorization.isPrime(n);
                    break;
                case "legendreSymbol":
                    int p = Integer.parseInt(params.get("p"));
                    result = LegendreSymbol.legendreSymbol(n, p);
                    break;
                default:
                    sendJson(exchange, "{\"error\":\"Unknown function\"}");
                    return;
            }

            String json = String.format(
                "{\"result\":%s,\"factorization\":\"%s\"}",
                result, escapeJson(formatFactorization(pf))
            );
            sendJson(exchange, json);
        } catch (Exception e) {
            sendJson(exchange, "{\"error\":\"" + escapeJson(e.getMessage()) + "\"}");
        }
    }

    private Map<String, String> parseQuery(String query) {
        Map<String, String> params = new HashMap<>();
        if (query == null) return params;
        for (String param : query.split("&")) {
            String[] pair = param.split("=", 2);
            if (pair.length == 2) params.put(pair[0], pair[1]);
        }
        return params;
    }

    private void sendJson(HttpExchange exchange, String json) throws IOException {
        byte[] bytes = json.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.getResponseBody().close();
    }

    private String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    private String formatFactorization(PrimeFactorization pf) {
        ArrayList<PrimeFactor> factors = pf.getFactorization();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < factors.size(); i++) {
            PrimeFactor f = factors.get(i);
            if (i > 1) sb.append(" \u00D7 ");
            sb.append(f.getValue()).append(toSuperscript(f.getExponent()));
        }
        if (sb.length() == 0) sb.append("1");
        return sb.toString();
    }

    private String toSuperscript(int n) {
        String digits = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (char c : digits.toCharArray()) {
            switch (c) {
                case '0': sb.append('\u2070'); break;
                case '1': sb.append('\u00B9'); break;
                case '2': sb.append('\u00B2'); break;
                case '3': sb.append('\u00B3'); break;
                case '4': sb.append('\u2074'); break;
                case '5': sb.append('\u2075'); break;
                case '6': sb.append('\u2076'); break;
                case '7': sb.append('\u2077'); break;
                case '8': sb.append('\u2078'); break;
                case '9': sb.append('\u2079'); break;
            }
        }
        return sb.toString();
    }
}
