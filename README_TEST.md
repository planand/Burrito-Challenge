Test the service:

1. Open Swagger at:
http://localhost:8080/swagger-ui/index.html#/

1.1 Create an order - The post payload can be a list order or unique order
/orders

1.2 Get an order:
a) Open H2 DB to find an order ID under table Orders
http://localhost:8080/h2-console/

b) Pass the order ID as parameter at:
/orders/{id}