Feature: sample
  Background:
    * url karate.properties['mock.cats.url']
#  Scenario: hello karate
#    * print 'hello'
  Scenario: labo test
    Given request { name: 'test'}
    When method get
    Then status 200