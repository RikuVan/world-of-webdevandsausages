import React from 'react'
import styled, { css } from '../../styles/styled-components'
import { NavLink as Link } from 'react-router-dom'
import { toRem } from '../../styles/helpers'
import darken from 'polished/lib/color/darken'
import transparentize from 'polished/lib/color/transparentize'
import { tablet, phone } from '../../styles/helpers'

const Wrapper = styled.nav`
  display: flex;
  align-items: center;
  flex: 0 0 auto;
  margin-left: 40px;
  ${tablet(`
    margin-left: 20px;
  `)}
  ${phone(`
    margin-left: 0px;
  `)}
`

const NavLink = styled(Link)<any>`
  flex: 0 0 auto;
  display: inline-block;
  ${({ theme }) =>
    css`
      line-height: ${toRem(theme.navHeight)};
    `};
  text-align: center;
  font-weight: 400;
  text-decoration: none;
  transition: opacity 0.2s, transform 0.2s;
  cursor: pointer;
  &:hover,
  &:focus {
    opacity: 0.8;
  }
  &:active {
    transform: scale(0.95);
    opacity: 0.6;
  }
  color: ${p => darken(0.1, p.theme.iconsColor)};
  ${({ disabled }) =>
    disabled &&
    css`
      color: ${p => transparentize(0.5, p.theme.iconsColor)};
      cursor: not-allowed;
      &:hover,
      &:focus {
        opacity: 1;
      }
      &:active {
        transform: none;
        opacity: 1;
      }
    `};
`

export const NavSeparator = styled.span`
  flex: 0 0 auto;
  width: ${toRem(5)};
  height: ${toRem(5)};
  margin: 0 ${toRem(15)};
  border-radius: 50%;
  background: black;
  opacity: 0.35;
`

const NavLinks = () => (
  <Wrapper>
    <NavLink id="home" activeClassName="active" to="/">
      HOME
    </NavLink>
    <NavSeparator />
    <NavLink id="about" activeClassName="active" to="/about">
      ABOUT
    </NavLink>
  </Wrapper>
)

export default NavLinks
