db.users.insertOne(
    {
        username: "hugo",
        password: "$2y$12$k0coIV45qtB2H24/XSYCyeLbwsdiV3tWpGmTFvm/zpm2Tz5/vHmXe"
    }
)
db.categories.insertMany([
    {
        "categoryName": "LeetCode"
    },
    {
        "categoryName": "Recipe"
    },
    {
        "categoryName": "Comparison"
    }])
db.articles.insertMany([
    {
        "categoryId": "",
        "title": "LC001",
        "tags": ["Array"],
        "references": ["LC002"],
        "publishDate": new Date("2020-09-20"),
        "modifiedDate": new Date("2020-09-29"),
        "contentUri": "/home/hugo/workspace/personal/blogs/LC001.LeetCode001"
    },
    {
        "categoryId": "",
        "title": "LC002",
        "tags": ["Array"],
        "references": ["LC001"],
        "publishDate": new Date("2020-09-25"),
        "modifiedDate": new Date("2020-09-29"),
        "contentUri": "/home/hugo/workspace/personal/blogs/LC002.LeetCode002"
    }
])
