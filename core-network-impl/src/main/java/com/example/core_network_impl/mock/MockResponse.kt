package com.example.core_network_impl.mock

import com.example.core_utils.domain.model.MainDTO
import com.google.gson.Gson

object MockResponse {
    fun getCardResponse(): MainDTO =
        Gson().fromJson<MainDTO>(
            """
            {
                "providers": [
                    {
                        "id": 1,
                        "title": "Amazon.com",
                        "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                        "gift_cards": [
                            {
                              "id": 1,
                              "featured": false,
                              "title": "            ${'$'}            10 Amazon.com",
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
                              "title": "            ${'$'}            20 Amazon.com",
                              "credits": 15000,
                              "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                              "codes_count": 4,
                              "currency": "USD",
                              "description": "Buy everything from Amazon. It's great.",
                              "redeem_url": "http://www.amazon.com"
                            },
                            {
                              "id": 3,
                              "featured": false,
                              "title": "            ${'$'}            30 Amazon.com",
                              "credits": 16000,
                              "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                              "codes_count": 7,
                              "currency": "USD",
                              "description": "Buy everything from Amazon. It's great.",
                              "redeem_url": "http://www.amazon.com"
                            },
                            {
                              "id": 4,
                              "featured": false,
                              "title": "            ${'$'}            40 Amazon.com",
                              "credits": 16500,
                              "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                              "codes_count": 9,
                              "currency": "USD",
                              "description": "Buy everything from Amazon. It's great.",
                              "redeem_url": "http://www.amazon.com"
                            },
                            {
                              "id": 5,
                              "featured": false,
                              "title": "            ${'$'}            60 Amazon.com",
                              "credits": 19000,
                              "image_url": "http://g-ec2.images-amazon.com/images/G/01/social/api-share/amazon_logo_500500.png",
                              "codes_count": 12,
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
                              "title": "            ${'$'}            10 iTunes Gift Card",
                              "credits": 8500,
                              "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from iTunes. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 102,
                              "featured": false,
                              "title": "            ${'$'}            20 iTunes Gift Card",
                              "credits": 9500,
                              "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from iTunes. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 103,
                              "featured": false,
                              "title": "            ${'$'}            30 iTunes Gift Card",
                              "credits": 10500,
                              "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from iTunes. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 104,
                              "featured": false,
                              "title": "            ${'$'}            40 iTunes Gift Card",
                              "credits": 11500,
                              "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from iTunes. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 105,
                              "featured": false,
                              "title": "            ${'$'}            50 iTunes Gift Card",
                              "credits": 12500,
                              "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from iTunes. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 106,
                              "featured": false,
                              "title": "            ${'$'}            60 iTunes Gift Card",
                              "credits": 14500,
                              "image_url": "https://www.ixbt.com/short/images/2017/Dec/card-25_8_3.jpg",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from iTunes. It's great.",
                              "redeem_url": "http://www.apple.com"
                            }
                        ]
                    },
                    {
                        "id": 3,
                        "title": "Steam",
                        "image_url": "https://logodix.com/logo/881500.png",
                        "gift_cards": [
                            {
                              "id": 201,
                              "featured": false,
                              "title": "            ${'$'}            10 Steam Gift Card",
                              "credits": 8500,
                              "image_url": "https://logodix.com/logo/881500.png",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from Steam. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 202,
                              "featured": false,
                              "title": "            ${'$'}            20 Steam Gift Card",
                              "credits": 9500,
                              "image_url": "https://logodix.com/logo/881500.png",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from Steam. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 203,
                              "featured": false,
                              "title": "            ${'$'}            30 Steam Gift Card",
                              "credits": 10500,
                              "image_url": "https://logodix.com/logo/881500.png",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from Steam. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 204,
                              "featured": false,
                              "title": "            ${'$'}            40 Steam Gift Card",
                              "credits": 11500,
                              "image_url": "https://logodix.com/logo/881500.png",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from Steam. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 205,
                              "featured": false,
                              "title": "            ${'$'}            50 Steam Gift Card",
                              "credits": 12500,
                              "image_url": "https://logodix.com/logo/881500.png",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from Steam. It's great.",
                              "redeem_url": "http://www.apple.com"
                            },
                            {
                              "id": 206,
                              "featured": false,
                              "title": "            ${'$'}            60 Steam Gift Card",
                              "credits": 14500,
                              "image_url": "https://logodix.com/logo/881500.png",
                              "codes_count": 101,
                              "currency": "USD",
                              "description": "Buy everything from Steam. It's great.",
                              "redeem_url": "http://www.apple.com"
                            }
                        ]
                    }
                ]
            }
        """, MainDTO::class.java
        )
}