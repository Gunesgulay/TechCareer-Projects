from locust import HttpUser, between, task

class WebsiteStore(HttpUser):
    wait_time = between(5, 15)

    def addPetFunction(self, id):
        body = {
            "id": id,
            "category": {
                 "id": 55,
                 "name": "cats"
             },
            "name": "scottish",
            "photoUrls": [
                    "example"
            ],
            "tags": [
                    {
                     "id": 555,
                     "name": "tag_name"
                     }
            ],
            "status": "available"
        }
        self.client.post("/v2/pet", json=body)

    def createOrderFunction(self, id):
        payload = {
            "id": id,
            "petId": 12,
            "quantity": 3,
            "shipDate": "2024-01-10T12:50:49.526Z",
            "status": "placed",
            "complete": True
        }
        self.client.post("/v2/store/order", json=payload)
        return payload

    @task
    def createOrder(self):
        self.addPetFunction(12)
        payload = self.createOrderFunction(1)
        self.client.post("/v2/store/order", json=payload)

    @task
    def getOrder(self):
        self.createOrderFunction(2)
        self.client.get("/v2/store/order/2")

    @task
    def deleteOrder(self):
        self.createOrderFunction(3)
        self.client.delete("/v2/store/order/3")
