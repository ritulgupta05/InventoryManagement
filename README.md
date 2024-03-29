# InventoryManagement

# Java, Maven, MySQL

curl --location 'http://localhost:8080/batches' \
--header 'Content-Type: application/json' \
--data '{
"mrp": 50,
"sp": 60,
"purchasePrice": -100,
"availableQuantity": -1,
"inwardedOn": "2025-02-02T10:00:00Z",
"gtinNumber": "G3"
}'




curl --location 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data '{
"productName": "Product D",
"createdOn": "2023-01-01T00:00:00Z"
}'


curl --location 'http://localhost:8080/gtins' \
--header 'Content-Type: application/json' \
--data '{
"gtinNumber": "G4",
"product": {
"product_id": 3
}
}'


curl --location 'http://localhost:8080/batches/positive-available-and-latest-negative-or-zero-batch'

![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)‣湉敶瑮牯䵹湡条浥湥ੴ