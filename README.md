# Closure Templates

This is Obvious' fork of
[Google Closure Templates](http://code.google.com/p/closure-templates).

We try to keep it reasonably up to date, but only after testing that it is
compatible with our products. There may occasionally be changes introduced to
work around temporary issues or to try out fixes in preparation of upstream
patches.

The package number reflects the date the last merge was taken from.

## NPM Package vs. Git Repo

The Git repo contains a copy of the Closure Template source and a package that
contains only the pre-built compiler jar and supporting files.  If you want access to
just the jar you should depend on "closure-templates".

## Merging from the main project

The 'pristine' branch contains only changes that we've pulled from the main repo.

The 'master' branch should always contain main repo changes, with our changes layered on top.

To sync changes from the main project, run the following:

```
# Create a temporary git repo from the SVN repo at code.google.com,
# push it to github, and delete it.
git svn clone --stdlayout https://closure-templates.googlecode.com/svn closure-templates
cd closure-templates
git remote add github git@github.com:Obvious/closure-templates
git checkout -b pristine
git push github pristine
cd ..
rm -fR closure-templates

# Clone the github repo, and rebase our changes on top.
git clone git@github.com:Obvious/closure-templates
cd closure-templates
git rebase pristine master
```

Minor note: In these instructions, we create two local repos (one cloned from code.google.com,
and the other cloned from github). It's totally possible to do this with one repo. I only
prefer using two repos because it's slightly easier to use the convention that I'm currently
writing to "origin".

## Contributing

This project isn't intended for external contribution, we suggest instead you
[send patches](https://code.google.com/p/closure-templates/)
directly.
