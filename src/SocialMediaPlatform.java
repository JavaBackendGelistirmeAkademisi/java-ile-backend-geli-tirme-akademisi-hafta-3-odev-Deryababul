import java.util.*;

public class SocialMediaPlatform {
    public static void main(String[] args) {
        User user1 = new User("derya");
        User user2 = new User("john");
        user1.follow(user2);
        user1.createPost("Hello World!");
        user2.createPost("Hi there!");

        user1.showPosts();
        user2.showPosts();

        Post user1Post = user1.getPost(0);
        if (user1Post != null) {
            System.out.println("User1's Post: " + user1Post.getContent());
        }

        user2.addCommentToPost(user1, 0, "Nice post!");
        user1.showPosts();
        user1.addToPostFavorites(user2, 0);
        user1.showFeed();
    }

    static class User {
        private String name;
        private LinkedHashMap<Integer, Post> posts;
        private HashSet<User> following;
        private TreeSet<Post> favorites;
        private int postCounter = 0; // Her kullanıcı için ayrı sayaç

        public User(String name) {
            this.name = name;
            this.posts = new LinkedHashMap<>();
            this.following = new HashSet<>();
            this.favorites = new TreeSet<>();
        }

        public String getName() {
            return name;
        }

        public void follow(User user) {
            following.add(user);
            System.out.println(name + " takip ediyor " + user.getName());
        }

        public List<Post> showPosts() {
            System.out.println(name + "'s Posts:");
            for (Post post : posts.values()) {
                System.out.println("Post ID: " + post.getId() + " Content: " + post.getContent());
                for (Comment comment : post.getComments()) {
                    System.out.println("  Comment: " + comment.getCommentText());
                }
            }
            return new ArrayList<>(posts.values());
        }

        public void createPost(String content) {
            Post newPost = new Post(postCounter++, this, content);
            posts.put(newPost.getId(), newPost);
            System.out.println(name + " yeni bir gönderi yayınladı: " + content);
        }

        public void addCommentToPost(User user, int postId, String comment) {
            Post post = user.getPost(postId);
            if (post != null) {
                post.addComment(new Comment(this, comment));
                System.out.println(name + ", " + user.getName() + "'in gönderisine yorum yaptı: " + comment);
            }
        }

        private Post getPost(int postId) {
            return posts.get(postId);
        }
        public void addToPostFavorites(User user, int postId){
            Post post = user.getPost(postId);
            if (post != null){
                favorites.add(post);
                System.out.println(name + ", " + user.getName() + "'in gönderisini beğendi. Gönderi:\n"+ post.getContent());
            }

        }
        public void showFeed(){
            System.out.println("\n" + name + "'in  Ana Sayfası");
            for (User user : following){
                user.showPosts();
            }


        }
    }

    static class Post implements Comparable<Post> {
        private int id;
        private User user;
        private String content;
        private List<Comment> comments;

        public Post(int id, User user, String content) {
            this.id = id;
            this.user = user;
            this.content = content;
            this.comments = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void addComment(Comment comment) {
            comments.add(comment);
        }

        @Override
        public int compareTo(Post other) {
            return Integer.compare(this.id, other.id);
        }
    }

    static class Comment {
        private User user;
        private String commentText;

        public Comment(User user, String commentText) {
            this.user = user;
            this.commentText = commentText;
        }

        public String getCommentText() {
            return commentText;
        }
    }
}
