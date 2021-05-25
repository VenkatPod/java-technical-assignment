# Notes

The assumption I made is the product will have only discount at a given time, and the discounts are linked to the product so that it can easily be attached or detached to a product.

The TotalCalculator is the class which i would improve so that it takes out the business logic and basket simply holds the shopping cart info like a data modal, i would make TotalCalculator as a service whcih takes in the basket and decorate with the total by calculating the discounts. The repo which holds discounts would make it pluggable so that it can have different variations of repo like for example in my implementation it is made a inmemory but depends on the requirement we can plugin a datastore repo and plugin TotalCalculator service (using spring dependency injection).
