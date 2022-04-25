package com.perficient.flowable.FlowableProcessDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleWorkflowService {
    @Autowired
    private RuntimeService runtimeService;
 
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void startProcess(Article article) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("author", article.getAuthor());
        variables.put("url", article.getUrl());
        System.out.println("Author name: "+article.getAuthor()+"  Article URL: "+article.getUrl());
        articleRepository.save(new Article(article.getAuthor(), article.getUrl()));
        runtimeService.startProcessInstanceByKey("articleReview", variables);
    }
 
    @Transactional
    public List<Article> getTasks(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
          .taskCandidateGroup(assignee)
          .list();
        return tasks.stream()
          .map(task -> {
              Map<String, Object> variables = taskService.getVariables(task.getId());
              System.out.println("Author: "+(String) variables.get("author")+"   URL"+(String) variables.get("url"));
              return new Article( (String) variables.get("author"), (String) variables.get("url"));
          })
          .collect(Collectors.toList());
        
    }
 
    @Transactional
    public void submitReview(Approval approval) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approval.isStatus());
        taskService.complete(approval.getId().toString(), variables);
    }
    
    public void createDemoUsers() {
        if (articleRepository.findAll().size() == 0) {
        	articleRepository.save(new Article("debashree", "http://google.com"));
        	articleRepository.save(new Article("sagar", "http://google.com"));
        }
    }
}
