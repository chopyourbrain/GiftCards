package com.example.giftcards.util.mock

object Response {
    val mainResponse = """{
    "providers": [
        {
            "id": 1,
            "title": "Amazon.com",
            "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
            "gift_cards": [
                {
                  "id": 1,
                  "featured": false,
                  "title": "${'$'}10 Amazon.com",
                  "credits": 8500,
                  "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                  "codes_count": 101,
                  "currency": "USD",
                  "description": "Buy everything from Amazon. It's great.",
                  "redeem_url": "http://www.amazon.com"
                },
                {
                  "id": 2,
                  "featured": false,
                  "title": "${'$'}20 Amazon.com",
                  "credits": 15000,
                  "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                  "codes_count": 4,
                  "currency": "USD",
                  "description": "Buy everything from Amazon. It's great.",
                  "redeem_url": "http://www.amazon.com"
                }
            ]
        },
        {
            "id": 2,
            "title": "iTunes",
            "image_url": "http://culttech.com/wp-content/uploads/2017/11/itunes-password.jpg",
            "gift_cards": [
                {
                  "id": 101,
                  "featured": false,
                  "title": "${'$'}10 iTines Gift Card",
                  "credits": 8500,
                  "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                  "codes_count": 101,
                  "currency": "USD",
                  "description": "Buy everything from iTunes. It's great.",
                  "redeem_url": "http://www.apple.com"
                }
            ]
        }
    ]
}"""
}