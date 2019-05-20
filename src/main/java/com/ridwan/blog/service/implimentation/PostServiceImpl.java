package com.ridwan.blog.service.implimentation;

import com.ridwan.blog.model.Post;
import com.ridwan.blog.repository.PostRepository;
import com.ridwan.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repo;

    @Override
    public Post createPost(Post post) {

        Post post1 = null;

        try {
            post1 = repo.save(post);
        }catch (Exception ex){

            ex.printStackTrace();
        }
        return post1;
    }

    @Override
    public Post updatePost(Post post) {
    	
    Post result = null;
    try {	

    result = repo.save(getPostById(post.getId()));
       
    }catch(Exception ex) {
    	ex.printStackTrace();
    }
    
    return result;
    }

    @Override
    public void deletePost(Post post) {
        repo.delete(getPostById(post.getId()));
    }

    @Override
    public Post getPostById(Long Id) {
        return repo.getOne(Id);
    }

    @Override
    public List<Post> getAllPosts() {
        return repo.findAll(sortByDateAsc());
    }

//    public Post getAllComments(Long Id) {
//        return repo.getOne(Id);
//    }

    private Sort sortByDateAsc() {
        return new Sort(Sort.Direction.DESC, "timestamp");
    }

    @Override
    public Post createComment(Post post) {
        Post post2 = null;

        try {
            post2 = repo.save(post);
        }catch (Exception ex){

            ex.printStackTrace();
        }
        return post2;
    }
}
