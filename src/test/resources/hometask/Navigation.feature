Feature: Navigation Feature

Scenario Outline: Navigate between screens and tabs
    When user taps <favorite> icon on Favorites screen
    Then <type> screen is displayed
    And screen with <expected_screen> content is displayed
    When user taps <tab> tab
    Then tab with <expected_tab> content is displayed
    When user navigates back
    Then Favorites screen is displayed

    Examples:
    |favorite|  type  |  expected_screen                  |  tab       |  expected_tab                    |
    |TOR     |  Team  | Toronto Maple Leafs, PLAYER STATS | TEAM STATS | OFFENSIVE STATS, DEFENSIVE STATS |
    |NHL     | League | NHL, NEWS, STANDINGS              | LEADERS    | Points, Goals Scored             |
    |L. James| Player | LeBron James, #23, CAREER         | INFO       | Birth Date, Birth Place, Height  |
