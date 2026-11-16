# SWE 432 Final · Boolean Truth Table Generator

This Java web coursework project takes a two-variable Boolean expression such as `A and B` or `A or B` and generates a truth table. For each of the four combinations of the input values, the table shows whether the expression is true or false.

## What the project contains

| File | Purpose |
| --- | --- |
| [`src/main/webapp/final.html`](src/main/webapp/final.html) | Form for entering an expression and choosing a display format: `T/F`, `t/f`, `1/0`, or `true/false`. |
| [`src/main/java/servlet/echoName.java`](src/main/java/servlet/echoName.java) | Servlet that reads the form fields, selects the operation, and writes the result as HTML. |
| [`src/main/java/launch/Main.java`](src/main/java/launch/Main.java) | Launcher for the embedded Tomcat server. It reads `PORT` and defaults to `8080`. |
| [`pom.xml`](pom.xml) and [`Procfile`](Procfile) | Maven dependencies, launcher packaging, and the historical Heroku start command. |

## Build and inspect locally

The original setup uses Java, Maven, and embedded Tomcat 8.5. From the repository root, Maven is configured to package the application and generate a `webapp` launcher.

```bash
mvn package
sh target/bin/webapp
```

The form is served as `/final.html` when the local server is listening. You can also open the HTML file directly to inspect the form. The form posts to `/servlet/echoName`, but the checked-in project has no explicit servlet mapping for that URL. Full form submission therefore depends on the deployment configuration. The servlet also echoes user input into HTML, so keep the historical demo local.

The server and deployment scaffold came from the [SWE 432 embedded Tomcat example](https://github.com/luminaxster/swe432tomcat).
