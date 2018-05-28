Feature: Keytorc Assignment

    Scenario: User should be signed in
        Given Visitor is on the HomePage
        When Customer login with "yalcingunal@gmail.com" email and "y1y1y1" password
        Then Customer should see Name and Surname as "Yalçın Günal" on Home Page

    Scenario: User should search
        Given Visitor is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "y1y1y1" password
        When Customer search with "samsung" word
        Then Customer should see "sonuç bulundu" result message

    Scenario: User should search and visit result pages
        Given Visitor is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "y1y1y1" password
        And Customer search with "samsung" word
        When Customer visit "2" th result page
        Then Customer should see "2" th page

    Scenario: User should see added product on Favorite List
        Given Visitor is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "y1y1y1" password
        And Customer search with "samsung" word
        And Customer visit "2" th result page
        When Customer should add to favorite "3" th product
        Then Customer should see product on Favorite List

    Scenario: User should remove added Favorite product from Favorite List
        Given Visitor is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "y1y1y1" password
        And Customer search with "samsung" word
        And Customer visit "2" th result page
        And Customer should add to favorite "3" th product
        When Customer should remove added favorite product from Favorite List
        Then Customer should see "Ürününüz listeden silindi." success message and removed favorite product from Favorite List
