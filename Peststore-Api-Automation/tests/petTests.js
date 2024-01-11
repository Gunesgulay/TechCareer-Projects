const chakram = require('chakram'), expect = chakram.expect;

describe("Pet Module", function() {

    it("GET - GetPetInfo", function () {
        const resBody = {
            "id": 30,
            "category": {
            "id": 50,
            "name": "reptiles"
            },
            "name": "gecko",
            "photoUrls": [
            "https://example.com/reptiles.jpg"
            ],
            "tags": [
            {
                "id": 3,
                "name": "cute"
            }
            ],
            "status": "available"
        };

        const response = chakram.get("https://petstore.swagger.io/v2/pet/30");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody);
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });  
   
    it("PUT - UpdatePet", function () {
        const resBody = {
            "code": 405,
            "type": "unknown"
        };

        const body = {
            "id": 20,
            "category": {
            "id": 4,
            "name": "Cats"
            },
            "name": "Scottish",
            "photoUrls": [
            "https://example.com/updated-photo.jpg"
            ],
            "tags": [
            {
            "id": 7,
            "name": "Updated Tag"
            }
            ],
            "status": "available"
        };

        const response = chakram.put("https://petstore.swagger.io/v2/pet/70", body);
        expect(response).to.have.status(405);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });
   
    it("DELETE - DeletePet", function () {
       const resBody = {
           "code": 200,
           "type": "unknown",
           "message": "30"
        };

        const response = chakram.delete("https://petstore.swagger.io/v2/pet/30");
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });
   
   it("GET - GetPetInfo Deleted Pet", function () {
       const resBody = {
           "code": 1,
           "type": "error",
           "message": "Pet not found"
        };

        const response = chakram.get("https://petstore.swagger.io/v2/pet/30");
        expect(response).to.have.status(404);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });

   it("POST - CreatePet", function () {
       const resBody = {
           "id": 30,
           "category": {
           "id": 50,
           "name": "reptiles"
           },
           "name": "gecko",
           "photoUrls": ["https://example.com/reptiles.jpg"  
           ],
           "tags": [
           {
            "id": 3,
            "name": "cute"
           }
           ],
           "status": "available"
        };

       const body = {
           "id": 30,
           "category": {
           "id": 50,
           "name": "reptiles"
           },
           "name": "gecko",
           "photoUrls": ["https://example.com/reptiles.jpg"  
           ],
           "tags": [
           {
            "id": 3,
            "name": "cute"
           }
           ],
           "status": "available"
        };

        const response = chakram.post("https://petstore.swagger.io/v2/pet", body);
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody); 
        expect(response).to.have.header('content-type', 'application/json'); 
        return chakram.wait();
    });
});