import React from 'react'
import styled, { css } from 'styled-components'
import Markdown from 'react-markdown/with-html'

const PromptLabel = () => <span className="terminal-prompt__label">$</span>

export const Prompt = styled.label`
  font-size: 1.2rem;
  font-weight: bold;
  color: ${({ theme }) => theme.primaryOrange};
  margin: 0;
  padding: 15px 0;
  line-height: 120%;
`

export const Out = styled.div`
  margin: 0;
  padding-left: 1.2rem;
  line-height: 100%;
  font-size: 1.2rem;
  ${({ theme }) =>
    css`
      color: #fff;
    `};
  a {
    color: white;
    border-bottom: 1px ${({ theme }) => theme.white} dashed;
    text-decoration: none;
  }
  p {
    line-height: 2;
  }
`

const Md = styled(Markdown)`
  > p {
    margin: 0;
  }
`

export const TerminalOut = ({ title, detail }: { title: string; detail: string }) => (
  <>
    <Prompt>
      <PromptLabel /> {title}
    </Prompt>
    <Out>
      <Md source={detail} escapeHtml={false} style={{ margin: 0 }} />
    </Out>
  </>
)
