# Social Media Platform

Bu proje, kullanıcıların birbirlerini takip edebildiği, gönderi oluşturabildiği, gönderilere yorum yapabildiği ve beğendikleri gönderileri favorilere ekleyebildiği basit bir sosyal medya platformunu simüle eder.

## Özellikler

- **Kullanıcı Oluşturma**: Kullanıcılar platformda bir hesap oluşturabilir.
- **Kullanıcı Takip Etme**: Kullanıcılar diğer kullanıcıları takip ederek, onların gönderilerinden haberdar olabilir.
- **Gönderi Oluşturma**: Kullanıcılar, içerik paylaşmak için gönderi oluşturabilir.
- **Gönderilere Yorum Yapma**: Kullanıcılar, kendi veya diğer kullanıcıların gönderilerine yorum yapabilir.
- **Akış Görüntüleme**: Kullanıcılar, takip ettikleri kişilerin gönderilerini bir akış üzerinde görüntüleyebilir.
- **Gönderileri Favorilere Ekleme**: Kullanıcılar, beğendikleri gönderileri favorilerine ekleyebilir.
- **Takip Edilen Kullanıcıların Gönderilerini Görüntüleme**: Kullanıcılar, takip ettikleri kullanıcıların gönderilerini görüntüleyebilir.

## Kullanım

Aşağıdaki örnek, projenin nasıl kullanılacağını adım adım göstermektedir:

1. **Kullanıcı Oluşturma**:
    ```java
    User user1 = new User("derya");
    User user2 = new User("deniz");
    ```

2. **Kullanıcı Takip Etme**:
    ```java
    user1.follow(user2);
    ```

3. **Gönderi Oluşturma**:
    ```java
    user1.createPost("This is my first post!");
    ```

4. **Gönderilere Yorum Yapma**:
    ```java
    user2.addCommentToPost(user1, 0, "Great post!");
    ```

5. **Akışı Görüntüleme**:
    ```java
    user1.showFeed();
    ```

6. **Gönderileri Favorilere Ekleme**:
    ```java
    user1.addToPostFavorites(user2, 0);
    ```

7. **Takip Edilen Kullanıcıların Gönderilerini Görüntüleme**:
    ```java
    user1.showPosts();
    ```

## Sınıf Yapısı

- **User**: Platformdaki bir kullanıcıyı temsil eder. Gönderi oluşturma, kullanıcı takip etme, gönderilere yorum yapma, akışı görüntüleme ve favorilere ekleme gibi işlemleri içerir.
- **Post**: Kullanıcı tarafından oluşturulan bir gönderiyi temsil eder. Gönderi ID'si, içerik ve yorumları depolar.
- **Comment**: Bir kullanıcı tarafından bir gönderiye yapılan yorumu temsil eder. Yorumu yapan kullanıcıyı ve yorum metnini depolar.


