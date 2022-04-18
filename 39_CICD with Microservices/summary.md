# (39) CI/CD with Microservices

## Resume
Dalam materi ini, mempelajari:
1. CI/CD
2. Automatic Deployment
3. Github Actions


### CI/CD
CI adalah proses pengujian dan pembuatan software secara otomatis setelah kode aplikasi yang baru terintegrasi ke dalam repository (tempat penyimpanan) bersama. Sedangkan CD adalah proses penyampaian aplikasi yang dibuat dalam proses CI ke bagian lingkungan produksi, yang dimasukkan melalui automated test.

### CI/CD Benefits
1. Increased speed of innovation and ability to compete in 
the marketplace
2. Code in production is making money instead of sitting in 
a queue waiting to be deployed
3. Great ability to attract and retain talent
4. Higher quality code and operations due to 
specialization

### Automatic Deployment
praktik yang memungkinkan Anda mengirimkan kode secara penuh atau semi-otomatis di beberapa tahap proses pengembangan - mulai dari pengembangan awal hingga produksi.

### Automatic Deployment Benefits
- Reduced Possibility of errors
- Saving time
- Consistency and repeatability

### Github Actions Example
```yaml
name: GitHub Actions Demo
on: [push]
jobs:
  Explore-GitHub-Actions:
    runs-on: ubuntu-latest
    steps:
      - run: echo "ðŸŽ‰ The job was automatically triggered by a ${{ github.event_name }} event."
      - run: echo "ðŸ§ This job is now running on a ${{ runner.os }} server hosted by GitHub!"
      - run: echo "ðŸ”Ž The name of your branch is ${{ github.ref }} and your repository is ${{ github.repository }}."
      - name: Check out repository code
        uses: actions/checkout@v3
      - run: echo "ðŸ’¡ The ${{ github.repository }} repository has been cloned to the runner."
      - run: echo "ðŸ–¥ï¸ The workflow is now ready to test your code on the runner."
      - name: List files in the repository
        run: |
          ls ${{ github.workspace }}
      - run: echo "ðŸ This job's status is ${{ job.status }}."
```

### Github Actions Spring
```yaml
name: Cl/CD Pipeline 
on:
 #Manually trigger workflow runs
 workflow dispatch:
 #Trigger the workflow on push from the main branch
 push:
   branches:
     - main
jobs:
 #Test's job
 tests:
   name: Untt tests
   #Run on Ubuntu using the latest version
   runs-on: ubuntu-latest
   #Job's steps
   Steps:
     #Check-out your repository under $GITHUB_WORKSPACE, so your workflow can access it
     - uses: actions/checkout@v1
     #Set up JDK 11
     - name: Set up JDK
       uses: actions/setup-java@v1
       with:
        java-version: '11'
     #Set up Maven cache
     - name: Cache Maven packages
       #This action allows cachtng dependencies and build outputs to improve workflow execution time. 
       uses: acttons/cacheevl
       with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles(1**/pom.xmll 
        restore-keys: ${{ runner.os }}-m2
     #Run Tests
     - name: Run Tests
       run: mvn -B test

```


## Task
### 1. Challenge 1
Pada task ini, mendeploy spring boot project ke AWS dengan github action

[Praktikum](./praktikum/alterra)

workflows.yml
```yml
name: Spring Boot Postgres Pipeline

on:
  push:
    branches:
      - master
  workflow_dispatch:

jobs:
  run_test:
    name: Unit Test
    runs-on: ubuntu-18.04
    steps:
      - run: echo "Starting execute unit test"
      - uses: actions/checkout@v3
      - name: Setup JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: 11
          distribution: 'adopt'
      - name: Maven Verify
        run: mvn clean verify

  build:
    name: Build
    runs-on: ubuntu-18.04
    needs: run_test
    steps:
      - run: echo "Starting build package"
      - uses: actions/checkout@v3
      - name: Setup JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: 11
          distribution: 'adopt'
      - name: Maven Build
        run: mvn clean package -Dmaven.test.skip=true
      - name: Login to docker hub
        uses: docker/login-action@v1
        with:
          username: ${{ secrets.DOCKERHUB_USERNAME }}
          password: ${{ secrets.DOCKERHUB_TOKEN }}
      - name: Build docker image
        uses: docker/build-push-action@v2
        with:
          context: .
          push: true
          tags: hendrojun/springboot-postgres:latest
  deployment:
    name: Deploy container using SSH
    runs-on: ubuntu-18.04
    needs: build
    steps:
      - run: echo "Starting deploy container"
      - uses: actions/checkout@v3
      - name: Copy environment file via ssh
        uses: appleboy/scp-action@master
        with:
          host: ${{ secrets.EC2_SSH_HOST }}
          port: 22
          username: ${{ secrets.EC2_SSH_USERNAME }}
          key: ${{ secrets.EC2_SSH_PRIVATE_KEY }}
          source: .dev.env
          target: /home/${{ secrets.EC2_SSH_USERNAME }}
      - name: Deploy using ssh
        uses: appleboy/ssh-action@master
        with:
          host: ${{ secrets.EC2_SSH_HOST }}
          port: 22
          username: ${{ secrets.EC2_SSH_USERNAME }}
          key: ${{ secrets.EC2_SSH_PRIVATE_KEY }}
          script: |
            docker stop springboot-postgres
            docker rmi hendrojun/springboot-postgres:latest
            docker pull hendrojun/springboot-postgres:latest
            docker run --name springboot-postgres -p 80:8080 -p 443:8080 --env-file=.dev.env --network alterra -d hendrojun/springboot-postgres:latest
```

output:

![Challenge 1](./screenshots/1.PNG)



