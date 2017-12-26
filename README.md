#COM3014 Group Project

##Best Practices
Follow the best practices as described here:
[http://nvie.com/posts/a-successful-git-branching-model/]

TL;DR version:
- checkout your `feature branch` using `git checkout my_feature`
- work on your feature and make sure it works
- before merging to `dev` make sure to merge the latest `dev` branch changes to your `feature branch`
-- `git checkout dev`
-- `git pull origin dev`
-- `git checkout me_feature`
-- `git merge dev`
- And then you can reverse the logic and merge your changes to `dev` branch and `git push origin dev`
-- If you want to be extra safe, you can push to you `my_feature` branch first and create a merge request to dev for other devs to review your changes.

### DO NOT merge to master, that branch is reserved for code that works 100% only.
