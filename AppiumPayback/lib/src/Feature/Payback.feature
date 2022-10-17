Feature: PayBack Mobile Application

  Scenario: Select REWE Coupon
    Given I open PayBack application in android
    When I click coupon button
    	And I filter and activate first "REWE" coupon
    Then I have activated the coupon