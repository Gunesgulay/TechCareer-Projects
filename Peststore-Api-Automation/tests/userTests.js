const chakram = require('chakram'), expect = chakram.expect;

describe("User Module", function() {

    it("GET - GetUserInfo", function () {
        const resBody = {
            "id": 7448,
            "username": "test89",
            "firstName": "ali",
            "lastName": "ulker",
            "email": "ali@gmail.com",
            "password": "09876",
            "phone": "4628692748",
            "userStatus": 0
         }

         const response = chakram.get("https://petstore.swagger.io/v2/user/test89");
         expect(response).to.have.status(200);
         expect(response).to.comprise.of.json(resBody);
         expect(response).to.have.header('content-type', 'application/json'); 
         return chakram.wait();
      });  
   
    it("DELETE - DeleteUser", function () {
        const resBody = {
            "code": 200,
            "type": "unknown",
            "message": "test89"
         };

         const response = chakram.delete("https://petstore.swagger.io/v2/user/test89");
         expect(response).to.have.status(200);
         expect(response).to.comprise.of.json(resBody); 
         expect(response).to.have.header('content-type', 'application/json'); 
         return chakram.wait();
      });

   
    it("GET - GetUserInfo Invalid User", function () {
        const resBody = {
            "code": 1,
            "type": "error",
            "message": "User not found"
         };

         const response = chakram.get("https://petstore.swagger.io/v2/user/test89");
         expect(response).to.have.status(404);
         expect(response).to.comprise.of.json(resBody); 
         expect(response).to.have.header('content-type', 'application/json'); 
         return chakram.wait();
      });

    it("POST - CreateUser", function () {
        const resBody = {
            "code": 200,
            "type": "unknown",
            "message": "7448"
         };

         const body = {
             "id": 7448,
             "username": "test89",
             "firstName": "ali",
             "lastName": "ulker",
             "email": "ali@gmail.com",
             "password": "09876",
             "phone": "4628692748",
             "userStatus": 0
         };

         const response = chakram.post("https://petstore.swagger.io/v2/user", body);
         expect(response).to.have.status(200);
         expect(response).to.comprise.of.json(resBody); 
         expect(response).to.have.header('content-type', 'application/json'); 
         return chakram.wait();
      });

   

    it("PUT - UpdateUser", function () {
        const resBody = {
            "code": 200,
            "type": "unknown",
            "message": "1004"
         };

         const body = {
             "id": 1004,
             "username": "test12345",
             "firstName": "ahmet",
             "lastName": "yılmaz",
             "email": "test@gmail.com",
             "password": "7890",
             "phone": "4789364736",
             "userStatus": 0
         }

         const response = chakram.put("https://petstore.swagger.io/v2/user/test123", body);
         expect(response).to.have.status(200);
         expect(response).to.comprise.of.json(resBody); 
         expect(response).to.have.header('content-type', 'application/json'); 
         return chakram.wait();
      });
});