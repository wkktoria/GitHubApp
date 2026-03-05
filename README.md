# GitHub App

## Acceptance Criteria

### First

As an API consumer, given **username** and **header `Accept: application/json`**,
I would like to list all the user's GitHub repositories, which are not forks.

Information, which I require in the response is:

- repository name,
- owner login,
- for each branch: its **name** and **last commit sha**.

### Second

As an API consumer, given **non-existing GitHub user**,
I would like to receive `404` response in such format:

```json
{
  "status": "${responseCode}",
  "message": "${whyHasItHappened}"
}
```

### Third

As an API consumer, given **header `Accept: application/xml`**,
I would like to receive `406` response in such format:

```json
{
  "status": "${responseCode}",
  "message": "${whyHasItHappened}"
}
```