const base = {
    get() {
        return {
            url : "http://localhost:8080/zhihuidianzishangwuxitong/",
            name: "zhihuidianzishangwuxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhihuidianzishangwuxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧社区电子商务系统"
        } 
    }
}
export default base
