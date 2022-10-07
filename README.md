# apk-test-framework

![apk-test-framework drawio (4)](https://user-images.githubusercontent.com/36144069/194526795-45f04325-6ffd-4b92-ab43-b06f943bfefb.png)

- git clone `<repoURL>`
- cd `<repoPath>`
- mvn [clean] test
- go test
- mvn [clean] install
- go build apkctl.go
- docker build -t wso2/my-app .
- wget `<URL>`
- kubectl wait --namespace default --for=condition=ready pod --selector=app.kubernetes.io/component=controller --timeout=480s
- ./apkctl install platform
- go test (in apkctl test dir)
- mvn [clean] verify (in APIs it tests root dir)
- npm run test (in ui tests root dir)
- ./apkctl uninstall platform
