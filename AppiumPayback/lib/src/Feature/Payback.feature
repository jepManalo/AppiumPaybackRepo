Feature: PayBack Mobile Application

  Scenario: Select REWE Coupon
    Given I open PayBack application in android
    When I complete action
    Then I validate the outcomes

#  Scenario Outline: Select different Coupons
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | CouponName  |
#      | REWE 			 |