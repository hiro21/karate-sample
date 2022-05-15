Feature:
  Background:
    * def m = {}
  Scenario: methodIs('get') && pathMatches('/facts')
    * def response = {result: 'ok'}
