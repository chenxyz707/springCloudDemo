# springCloudDemo

## Eureka
Eureka的高可用需要修改host文件添加一行
`127.0.0.1  eureka1 eureka2 eureka3`

##配置中心
启动之前请修改配置中心的仓库地址
###关于GitLab
GitLab使用`Docker`部署
```shell
docker pull gitlab/gitlab-ce
```
如果从Docker仓库获取太慢或者经常失败，可以从国内仓库获取。
```shell
docker pull registry.docker-cn.com/gitlab/gitlab-ce
```
运行指令
```shell
docker run -d -p 1443:443 -p 10800:80 --name gitlab --restart always gitlab/gitlab-ce:latest
```
启动后直接根据http://ip:10800访问GitLab需要初始化密码，这里修改密码为`123456789`。
如果访问502，仔细查看内存是否足够。此处使用4G内存，3G可能会有问题。

**当然如果直接使用GitHub就不用考虑这些问题**

##其他


