# Android Git Fundamentals

## Introduction

This exercise will give you practice untangling merge conflicts, fixing an Android app and using git-flow. The finished product should be a simple Material design Activity with a Drawer.

## Instructions

### Part 1 - Fork and clone
1. Fork this repo and then clone it on your local machine

### Part 2 - Checkout the development branch
This repo has 3 branches:
  * `master`, which will contain your production release
  * `development`, which will contain your main development work
  * `conflicts`, the branch which you will merge with `development`
1. Fetch all branches from remote:
`git fetch origin`
2. Checkout the `development` branch:
`git checkout origin/development`
3. Attempt to run the project in Android Studio, you'll see there are a lot of syntax errors
4. Merge the development branch with `conflicts`:    

      `git merge origin/conflicts`
      
You should run into a bunch of merge conflicts across various project files. 

### Part 3 - Fix conflicts and merge
1. Use Android Studio to carefully comb through the code and fix all merge conflicts + syntax errors
2. Once this is done and your application runs:
  1. create a new branch
  2. **merge** your branch with `master`
  3. create a pull request to `master`

### Part 4 - Fix conflicts and rebase
1. Use Android Studio to carefully comb through the code and fix all merge conflicts + syntax errors
2. Once this is done and your application runs:
  1. create a new branch
  2. **rebase** your branch with `master`
  3. create a pull request to `master`

### Part 5 - Create a tag
After your pull-request is merged into `master`, create a tagged release called `v1.0.0` and push it to GitHub.

### Part 6 - Optional Stretch-Goal
Use Android Studio's VCS / git tools to resolve merge conflicts visually. Discuss this experience with your classmates.
