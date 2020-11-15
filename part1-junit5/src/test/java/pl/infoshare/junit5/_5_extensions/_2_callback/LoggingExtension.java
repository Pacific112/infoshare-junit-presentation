package pl.infoshare.junit5._5_extensions._2_callback;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

import java.util.Random;

public class LoggingExtension implements BeforeEachCallback, BeforeAllCallback, AfterEachCallback, AfterAllCallback {

    private static final Namespace LOGGING_NAMESPACE = Namespace.create("logging-namespace");

    private static final Random RANDOM = new Random();

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("[Before all] I am calling from logging extension: " + context.getDisplayName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        var randomNumber = RANDOM.nextInt();

        context.getStore(LOGGING_NAMESPACE).put("randomNumber", randomNumber);
        System.out.println("[Before each] I am calling from logging extension: " + context.getDisplayName() + " " + randomNumber);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        var randomNumber = context.getStore(LOGGING_NAMESPACE).get("randomNumber");
        System.out.println("[After each] I am calling from logging extension: " + context.getDisplayName() + " " + randomNumber);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("[After all] I am calling from logging extension: " + context.getDisplayName());
    }
}
