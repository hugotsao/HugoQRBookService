db.users.insertOne(
{username: "hugo",
 password: "$2y$12$k0coIV45qtB2H24/XSYCyeLbwsdiV3tWpGmTFvm/zpm2Tz5/vHmXe"}
)
db.categories.insertMany([{
                            	"categoryName":"LeetCode"
                            },
                            {
                            	"categoryName":"Recipe"
                            },
                            {
                            	"categoryName":"Comparison"
                            }]);