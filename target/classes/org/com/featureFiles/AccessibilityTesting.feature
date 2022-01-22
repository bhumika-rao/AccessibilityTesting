Feature: Accesibility Tests

  @Test1
  Scenario Outline: TC01-PrintResultsOfWebContentAccessibilityGuidelines
    Given Launch the "<Browser>" "<BrowserVersion>" and navigate to "<URL>"
    Then find and print the number of passed items for ConformanceLevel "<ConformanceLevel>"
    And find and print the number of violation items for ConformanceLevel "<ConformanceLevel>"
    And find and print the number of review items for ConformanceLevel "<ConformanceLevel>"
    And find and print the number of inapplicable items for ConformanceLevel "<ConformanceLevel>"

    Examples: 
      | Browser | BrowserVersion | URL                     | ConformanceLevel |
      | Chrome  |           96.0 | https://www.amazon.com/ | wcag2aaa         |

  @Test2
  Scenario Outline: TC02-CheckForColourContrastAnalyser
    Given Launch the "<Browser>" "<BrowserVersion>" and navigate to "<URL>"
    And find and print the number of violation items for Rule "<RuleToCheck>" and ConformanceLevel "<ConformanceLevel>"

    Examples: 
      | Browser | BrowserVersion | URL                     | ConformanceLevel | RuleToCheck    |
      | Chrome  |           96.0 | https://www.amazon.com/ | wcag2aa          | color-contrast |
