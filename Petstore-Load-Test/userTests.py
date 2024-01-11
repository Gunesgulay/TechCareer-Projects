from locust import HttpUser, between, task

class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    def createUserFunction(self, id, username):
        payload = {
            "id": id,
            "username": username,
            "firstName": "test87",
            "lastName": "example",
            "email": "api80@gmail.com",
            "password": "111",
            "phone": "5064732018",
            "userStatus": 1
        }
        self.client.post("/v2/user", json=payload)

    @task
    def deleteUser(self):
        self.createUserFunction(9090, "api80")
        self.client.delete("/v2/user/api80")

    @task
    def createUser(self):
        self.createUserFunction(85,"successful")

    @task
    def getUserInfo(self):
        self.createUserFunction(9090, "api80")
        self.client.get("/v2/user/api80")

    @task
    def login(self):
        self.client.get("/v2/user/login?username=load&password=98765")

    @task
    def logout(self):
        self.client.get("/v2/user/logout")    

    @task
    def uptadeUser(self):
        body = {
            "id": 8080,
            "username": "api",
            "firstName": "test",
            "lastName": "example",
            "email": "api@gmail.com",
            "password": "7438",
            "phone": "5064793618",
            "userStatus": 0
        }
        self.client.put("/v2/user/load", json=body)
    




