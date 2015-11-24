package org.rapidpm.ddi.examples.example004.ui;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.example004.ui.main.MainPane;
import org.rapidpm.proxybuilder.type.dymamic.metrics.MetricsRegistry;

import java.util.concurrent.TimeUnit;


public class Main extends Application {

  private ConsoleReporter reporter;

  public static void main(String[] args) {
    DI.activatePackages("org.rapidpm"); // speed up startup
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    startMetrics();

    MainPane root = new MainPane();
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  private void startMetrics() {
    final MetricRegistry metrics = MetricsRegistry.getInstance().getMetrics();
    reporter = ConsoleReporter.forRegistry(metrics)
        .convertRatesTo(TimeUnit.NANOSECONDS)
        .convertDurationsTo(TimeUnit.MILLISECONDS)
        .build();
    reporter.start(1, TimeUnit.SECONDS);
  }


}
