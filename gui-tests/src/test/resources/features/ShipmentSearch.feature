Feature: Shipment Search scenarios

  Scenario Outline: User uses shipment number to verify it's status
    Given user enters InPost home page
    And user clicks accept in Cookies Alert if displayed
    When user enters parcel number "<parcelNumber>" in search input
    And user clicks find button
    Then page header "Track shipment" is displayed
    And shipment number "<parcelNumber>" is displayed in the header
    And active shipment status is "<parcelStatus>"
    Examples:
      | parcelNumber             | parcelStatus        |
      | 520113014230722029585646 | Delivered           |
      | 520107010449991105638120 | Passed for delivery |
      | 523000016696115042036670 | Label nullified     |
      | 520000011395200025754311 | Delivered           |