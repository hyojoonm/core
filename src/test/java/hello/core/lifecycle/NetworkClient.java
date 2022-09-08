package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connet(){
        System.out.println("connet: " + url);
    }

    public void call(String message){
        System.out.println("call " + url + " message = " +message );
    }
    // 서비스 종료시 호출
    public void disconntect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init()  {
        System.out.println("네트워크 클라이언트 init");
        connet();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("네트워크 클라이언트 close");
        disconntect();
    }
}
