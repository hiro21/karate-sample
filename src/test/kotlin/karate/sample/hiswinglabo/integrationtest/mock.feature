Feature:
  Background:
    * def m = {}
  Scenario: pathMatches('/test')
    * def response = m["test": "test1"]