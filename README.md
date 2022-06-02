# DemoProductRest

**Project Structure**

![Full-project structure](https://user-images.githubusercontent.com/20375942/171580188-a358f055-c39d-42f7-b0ed-554099929987.png)

**Database design**

![databse (mydb) deisgn](https://user-images.githubusercontent.com/20375942/171583367-4c27787d-be3d-4d95-a1fd-345c37870e58.png)


**1. Get request (Read product item)**

[See all products](http://localhost:8086/products)

**Response**

``
[
    {
        "id": 2,
        "name": "Realme 20",
        "price": 33090.0
    },
    {
        "id": 3,
        "name": "Xiaomi 9",
        "price": 25600.0
    },
    {
        "id": 5,
        "name": "Realme 80j",
        "price": 83300.5
    },
    {
        "id": 9,
        "name": "Realme 10",
        "price": 33090.0
    }
]
``

![image](https://user-images.githubusercontent.com/20375942/171580528-c68c1399-8967-43c0-890c-3c5b5bec1823.png)

**2. Post request (Save product item to DB)**

[Save product to DB](http://localhost:8086/products)

**Request to save data**

``
{
    "name": "Realme 89j",
    "price": 800.5
}
``

**Response _if product saved or not_**

![Response-see all product](https://user-images.githubusercontent.com/20375942/171581534-7a5280fe-f687-4341-81ad-908b5474dd08.png)


**Save signle product to DB**

![Send product item](https://user-images.githubusercontent.com/20375942/171581050-b89ee66b-6dd8-4a45-bf1b-d43530eea2d9.png)


**3. Put request (Update product item to DB)**

[Update product-2 to DB](http://localhost:8086/products/2)

**Request in JSON body**

``
{
    "id" : 2,
    "name": "Realme 8",
    "price": 13000
}
``

**Response**

_Run Get method to see if product gets updated or not._

**4. Delete product**

**Delete product-4**

[Request for delete](http://localhost:8086/products/4)

**Response**

_Run Get method to see if product gets deteled or not._

