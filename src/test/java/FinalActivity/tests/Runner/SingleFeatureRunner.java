package FinalActivity.tests.Runner;

public class SingleFeatureRunner {
    public static void main(String[] args) {
        io.cucumber.core.cli.Main.main("--glue", "FinalActivity.tests.StepDefinitions",
                "--plugin", "pretty",
                "src/test/resources/Features/");
    }
}
