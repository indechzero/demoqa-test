package FinalActivity.tests.Runner;

public class SingleFeatureRunner {
    public static void main(String[] args) {
        io.cucumber.core.cli.Main.main(new String[]{
                "--glue", "FinalActivity.tests.stepDefinitions",
                "--plugin", "pretty",
                "src/test/java/Resources/alertsAndWindows.feature"
        });
    }
}
