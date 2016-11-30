<%-- 
    Document   : search
    Created on : Nov 30, 2016, 1:48:27 PM
    Author     : lujamanandhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

 
<div >



    <form action="/catalog/" class="form-horizontal" 
          method="post">
        <label class="offscreen"  for="onesearch-query-front">Start your research</label>
        <input class="onesearch_input form-control" id="onesearch-query-front" name="onesearch-query" 
               placeholder="Find books, ebooks and more" 
               type="text" value="">
        <div class="search-choices"><label 
                for="onesearch-title-only-front">By title</label>&nbsp;&nbsp;
            <input id="onesearch-title-only-front" name="onesearch-title-only-front" 
                   type="checkbox" value=""> &nbsp;<label for="onesearch-online-front">&nbsp;Online only</label>&nbsp; &nbsp;<input id="onesearch-online-front" name="onesearch-online" type="checkbox" value=""></div>
        <p><input class="btn btn-primary" id="onesearch-submit" 
                  name="submit" type="submit" value="Search">&nbsp;</p></form>
</div>
