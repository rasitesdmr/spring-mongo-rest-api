package com.example.Api;

import com.example.Entity.User;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserApi {

    /*
     @Autowired anotasyonu sayesinde bir bean içerisindeki değerleri başka beanin içerisine
     enjekte edebilir değerlerini koruyarak kullanabiliriz. @Autowired anotasyonunu bir değişken,
     setter ya da yapılandırıcı metot üzerinde kullanılabilmekteyiz.
     */
    @Autowired
    private UserRepository userRepository;


    /*
    ResponseEntity sınıfı HttpEntity sınıfına ek olarak builder tasarım desenini kullanarak
    isteğe yanıt olarak header bilgisi, HTTP durum kodu gibi bilgileri eklemeyi sağlar.
   ------------------------------------------------------------------------------------------------------------
    POST: Bu metod ile sunucuya veri yazdırabilirsiniz.
    Bu metodla istek parametreleri hem URL içinde hem de mesaj gövdesinde gönderilebilir.
    Sadece mesaj gövdesinin kullanımı yukarıda sayılan riskleri engelleyecektir.
    Tarayıcılar geri butonuna basıldığında POST isteğinin mesaj gövdesinde yer alan parametreleri
    tekrar göndermek isteyip istemedimizi sorarlar. Bunun temel nedeni bir işlemi yanlışlıkla birden
    fazla yapmayı engellemektir. Bu özellik ve de güvenlik gerekçeleriyle bir işlem gerçekleştirileceğinde
    POST metodunun kullanılması önerilir.
    --------------------------------------------------------------------------------------------------------------
    Request Body ve Response Body olarak iki çeşit bulunmaktadır.
    Request Body gönderdiğimiz HTTP isteğinin Body sidir.
    Response Body ise sunucu tarafından bize gönderilen yanıtın Body sidir.
     */
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    /*
    GET: Bu metod sunucudan veri almak için kullanılır.
    GET ve POST metodları en sık kullanılan metodlar olup sunucudaki kaynaklara erişmek için kullanılırlar.
    GET metodu ile sorgu metinleri URL içinde gönderilebilir.
    Bunun en önemli faydası kullanıcıların bookmark edebilmeleri ve aynı sorguyu içeren istekleri
    daha sonra gönderebilmelerini sağlaması ve tarayıcıda önceki sorguların “geri” tuşu ile veya tarayıcı
    geçmişinden çağrılarak aynı sayfalara ulaşabilmeleridir. Güvenlik açısından URL’lerin ekranda görüntüleniyor
    olması ve URL’in hedefine ulaşıncaya kadar ve hedef sunucu üzerinde iz kayıtlarında görülebilmesi gönderilen
    parametrelerin gizlilik ihtiyacı varsa sıkıntı yaratabilir. Bu nedenlerle hassas isteklerin GET ile gönderilmemelidir.
    */
    @GetMapping
    public ResponseEntity<List<User>> allList(){
        return ResponseEntity.ok(userRepository.findAll());
    }

/*
Nesneyi başlatmak için JVM, <init>  adlı özel bir yöntemi çağırır .
JVM jargonunda bu yöntem bir örnek başlatma yöntemidir .
Bir yöntem, yalnızca ve yalnızca şu durumlarda bir örnek başlatmadır:
Bir sınıfta tanımlanır
Adı  < init>
Boşluk döndürür
Her sınıf, sıfır veya daha fazla örnek başlatma yöntemine sahip olabilir .
Bu yöntemler genellikle Java veya Kotlin gibi JVM tabanlı programlama dillerindeki yapıcılara karşılık gelir.
-------------------------------------------------------------------------------------------------------------
@PostConstruct Notasyonu
Bu notasyon doğrudan JSR 346: Contexts and Dependency Injection for Java EE 1.1 belirtimi altında bulunmaktan ziyade,
JSR 250 Commons Annotations belirtimi altında yer almaktadır. Görevi ise, bir nesne oluşturulduktan hemen sonra herhangi
 uygulanan bir metoda giriş sağlaması ve o metodu işletmesidir.
 */
    @PostConstruct
    public void init(){
        User user = new User();
        user.setFirstName("Rasit");
        user.setLastName("Eşdemir");
        userRepository.save(user);
    }
}
