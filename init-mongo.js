db.users.insertOne(
{username: "hugo",
 password: "I3A0WnZMMCF0Y0Nh"}
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