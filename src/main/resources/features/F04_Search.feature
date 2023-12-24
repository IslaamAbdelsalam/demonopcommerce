@Smoke
  Feature: Search Feature
    Scenario Outline: User could search using product name
      Given User navigates to home page
      When  User enters product name or Sku "<productName>"
      And User clicks on search button
      Then Products that searched by name will be displayed "<productName>"

      Examples:
        |  productName |
        |  book        |
        |  laptop      |
        |  nike        |

    Scenario Outline: User could search using product Sku
      Given User navigates to home page
      And  User enters product name or Sku "<productSku>"
      And User clicks on search button
      When User clicks product in search result
      Then Verify Sku displayed as searched "<productSku>"

      Examples:
        |  productSku       |
        |  SCI_FAITH        |
        |  APPLE_CAM        |
        |  SF_PRO_11        |
