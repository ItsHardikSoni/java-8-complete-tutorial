# Contributing to Java 8 Tutorial

Thank you for helping improve this Java 8 learning repository. Contributions to tutorials, practice questions, Java examples, explanations, formatting, and fixes are welcome.

## Ways to Contribute

- Improve an existing tutorial or fix an error.
- Add or improve a Java practice program.
- Add clear explanations and beginner-friendly examples.
- Fix broken links, formatting, spelling, or license information.
- Report an issue when an example or instruction does not work.

## Before Making Changes

1. Check the existing issues and pull requests to avoid duplicate work.
2. Open an issue for a large or uncertain change before starting.
3. Keep changes focused on one tutorial, chapter, or issue.
4. Preserve the educational and beginner-friendly style of the repository.

## Content Guidelines

- Target Java 8 unless a chapter clearly documents a newer concept.
- Use meaningful class and file names that match the existing chapter structure.
- Keep examples simple, self-contained, and easy to compile.
- Follow Java naming conventions and format code consistently.
- Prefer explanations that describe both the code and the result.
- Do not add secrets, database passwords, personal data, or third-party copyrighted text.
- If an example requires a database or external tool, document the setup and prerequisites.

## Making a Pull Request

1. Fork the repository and create a branch from `main`.
2. Make the smallest complete set of changes for the requested improvement.
3. Update the relevant README or practice index when adding or moving content.
4. Verify links and run or compile the affected Java examples when possible.
5. Commit your changes with a clear description.
6. Open a pull request and explain what changed, why it helps, and how it was tested.

## Java Example Checks

For an example at `path/Example.java`, compile and run it from the repository root when it has no external dependencies:

```bash
javac path/Example.java
java -cp path Example
```

Remove generated `.class` files before committing:

```bash
find . -type f -name "*.class" -delete
```

JDBC examples may require a database, JDBC driver, and local configuration. Do not commit real credentials.

## Documentation License

By contributing, you agree that your source code contributions are covered by the [MIT License](LICENSE) and your documentation or educational-text contributions are covered by the [Creative Commons Attribution 4.0 International License](LICENSE-DOCUMENTATION).

## Questions

For questions or suggestions, open an issue in this repository.
