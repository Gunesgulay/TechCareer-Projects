const chakram = require('chakram'), expect = chakram.expect;

describe("Order Module", function() {

    it("POST - CreateOrder", function () {
        const resBody = {
            "id": 8,
            "petId": 30,
            "quantity": 1,
            "shipDate": "2023-12-28T13:49:55.746+0000",
            "status": "placed",
            "complete": true
        };
  
        const body = {
            "id": 8,
            "petId": 30,
            "quantity": 1,
            "shipDate": "2023-12-28T13:49:55.746Z",
            "status": "placed",
            "complete": true
        };
  
        const response = chakram.post("https://petstore.swagger.io/v2/store/order", body);
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });

   it("GET - GetOrderInfo", function () {
       const resBody = {
           "id": 8,
           "petId": 30,
           "quantity": 1,
           "shipDate": "2023-12-28T13:49:55.746+0000",
           "status": "placed",
           "complete": true
        };

        const response = chakram.get("https://petstore.swagger.io/v2/store/order/8");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody);
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });  
   
   it("DELETE - DeleteOrder", function () {
       const resBody = {
           "code": 200,
           "type": "unknown",
           "message": "8"
        };

        const response = chakram.delete("https://petstore.swagger.io/v2/store/order/8");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });

   
   it("GET - GetOrderInfo Deleted Order ", function () {
       const resBody = {
           "code": 1,
           "type": "error",
           "message": "Order not found"
        };

        const response = chakram.get("https://petstore.swagger.io/v2/store/order/8");
        expect(response).to.have.status(404);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });
});