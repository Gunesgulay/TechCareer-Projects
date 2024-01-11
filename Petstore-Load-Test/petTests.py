from locust import HttpUser, between, task

class WebsitePet(HttpUser):
    wait_time = between(5, 15)

    def addPetFunction(self, id):
        payload = {
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
        response = self.client.post("/v2/pet", json=payload)
        return response

    @task
    def addPet(self):
        payload = {
            "id": 5,
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
        self.client.post("/v2/pet", json=payload)

    @task
    def getPetInfo(self):
        self.addPetFunction(5)
        self.client.get("/v2/pet/5")

    @task
    def deletePetInfo(self):
        self.addPetFunction(9)
        self.client.delete("/v2/pet/9")

    @task
    def updatePetInfo(self):
        body = {
            "id": 7,
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
        self.client.put("/v2/pet", json=body)

