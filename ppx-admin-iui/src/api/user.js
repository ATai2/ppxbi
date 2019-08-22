import requestapi from '@/utils/requestapi'

export function getUsers() {
  return requestapi({
    url: '/user/users',
    method: 'get'
  })
}

export function getInfo(token) {
  return requestapi({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return requestapi({
    url: '/user/logout',
    method: 'post'
  })
}
